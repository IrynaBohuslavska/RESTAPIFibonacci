package com.task.demo.service;

import com.task.demo.entity.Fibonacci;
import com.task.demo.exception.SequenceIsNotFibonacciException;
import com.task.demo.repository.FibonacciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FibonacciService {

    @Autowired
    private FibonacciRepository repository;

    public Fibonacci addReverseSequenceIfFibonacci(Fibonacci fibonacci) {
        List<Integer> list = this.takeNumbersFromSequence(fibonacci.getSequence());
        if (!checkIfFibon(list)) {
            throw new SequenceIsNotFibonacciException("This sequence is not fibonacci sequence");
        }
        fibonacci.setSequence(this.createReverse(list));
        return repository.save(fibonacci);
    }

    public List<Integer> takeNumbersFromSequence(String input) {
        ArrayList<Integer> res = new ArrayList<>();
        StringBuilder holder = new StringBuilder();
        StringBuilder inputBuilder = new StringBuilder(input).append(' ');

        for (int i = 0; i < inputBuilder.length(); i++) {
            if (!holder.toString().isEmpty() && inputBuilder.charAt(i) == ' ') {
                res.add(Integer.parseInt(String.valueOf(holder)));
                holder.setLength(0);
            }
            if (inputBuilder.charAt(i) != ' ')
                holder.append(inputBuilder.charAt(i));
        }
        return res;
    }

    public String createReverse (List<Integer> res){
        ArrayList<Integer> reverRes = new ArrayList<>();
        for (int i = res.size() - 1; i >= 0; i--)
            reverRes.add(res.get(Integer.parseInt(String.valueOf(i))));
        return reverRes.toString();
    }


    public boolean checkIfFibon (List<Integer> input){
        for (int i = 2; i < input.size(); i++) {
            if (input.get(i-2)+input.get(i-1) != input.get(i))
                return false;
        }
        return true;
    }

    public List<Fibonacci> findAll() {
        return repository.findAll();
    }
}
