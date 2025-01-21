<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class UserControler extends Controller
{
    public function allUser(){
        $cesaeInfo = $this->getCesaeInfo();
        $userInfo = $this->getAllUsers();
        return view('users.all_users', compact('cesaeInfo', 'userInfo'));
    }

    public function nameUser($name){
        return '<h1>Hello </h1>'.$name;
    }

    public function addUser(){
        return view('users.add_users');
    }

    private function getCesaeInfo(){
        $userInfo = [
            'name' => 'Cesae',
            'address' => 'R. de Ciríaco Cardoso 186, 4150-212 Porto',
            'email' => 'cesae@cesae.com'
        ];
        return $userInfo;
    }

    protected function getAllUsers(){
        $userInfo = [
            ['name' => 'Sara', 'id' => 1, 'phone' => '999999999'],
            ['name' => 'Bruno', 'id' => 2, 'phone' => '888888888'],
            ['name' => 'Márcia', 'id' => 3, 'phone' => '777777777']
        ];
        return $userInfo;
    }
}
