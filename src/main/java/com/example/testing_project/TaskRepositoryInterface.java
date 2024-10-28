package com.example.testing_project;

import java.util.List;
import java.util.Optional;

public interface TaskRepositoryInterface {
List<Task> findAll();

Optional<Task> findById(Long id);

Task save(Task task);

void deleteById(Long id);
}
