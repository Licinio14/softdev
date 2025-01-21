<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class TasksControler extends Controller
{
    public function allTasks(){
        $tasks = $this->getAllTasks();
        $availableTasks = $this->getAvailableTasks();

        return view('tasks.all_tasks',compact('tasks','availableTasks'));
    }


    private function getAllTasks(){
        $tasks = [
            ['name' => 'Rita', 'task' => 'estudar laravel'],
            ['name' => 'Joao', 'task' => 'estudar Mysql']
        ];

        return $tasks;
    }

    private function getAvailableTasks(){
        $availableTasks=['sql', 'js', 'Java', 'POO'];
        return $availableTasks;
    }
}
