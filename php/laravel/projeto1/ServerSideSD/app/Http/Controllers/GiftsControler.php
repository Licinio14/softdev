<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

class GiftsControler extends Controller
{

    public function showAllGifts(){

        $data = $this->getAllGifts();


        return view('gifts.all_gifts', compact('data'));
    }

    public function showInfoGifts($id){

        $data = db::table('gifts')
        ->where('gifts.id',$id)
        ->join('users', 'users.id', '=', 'gifts.user_id')
        ->select('gifts.*','users.name as userName')
        ->get();

        return view('gifts.info_gifts', compact('data'));
    }

    public function deleteGifts($id){


        DB::table('gifts')
        ->where('id',$id)
        ->delete();

        $data = $this->getAllGifts();


        return view('gifts.all_gifts', compact('data'));
    }

    protected function getAllGifts(){

        $data = DB::table('gifts')
        ->join('users', 'users.id', '=', 'gifts.user_id')
        ->select('gifts.*','users.name as userName')
        ->get();
        return $data;
    }

}
