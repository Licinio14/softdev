<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use App\Http\Controllers\Controller;

class UserControler extends Controller
{
    public function allUser(){
        $cesaeInfo = $this->getCesaeInfo();
        $userInfo = $this->getAllUsers();

        $contactPerson = DB::table('users')->where('name', 'Licinio')->first();

        $this->updadetUserAtDB();

        // $this->deletUserAtDB(3);

        return view('users.all_users', compact('cesaeInfo', 'userInfo','contactPerson'));
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

        $userInfo = DB::table('users')
        ->select('name','email','password','id')
        ->get();

        return $userInfo;
    }

    public function insertUser(){
        DB::table('users')
        ->insert([
            'name'=> 'Licinio3',
            'email' => 'l3@gmail.com',
            'address' => 'dwadwefeafraf',
            'password' => '1234'
        ]);

        // caso usasse a rota para chamar a função, retornaria algo para informar o utilizador
        // return response()->json('utilizador inserido');
    }

    public function updadetUserAtDB(){
        DB::table('users')
        ->where('id',1)
        ->update([
            'email_verified_at'=> now(),
            'address' => 'Rua nova atualizada',
            'updated_at' => now()
        ]);
    }

    protected function deletUserAtDB($id){

        DB::table('users')
        ->where('id',$id)
        ->delete();

    }
}
