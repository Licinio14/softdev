<?php

use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/home', function(){
    return view('home');
})->name('home');

Route::get('/users', function(){
    return view('users.all_users');
})->name('users.show');

Route::get('/hello/{name}', function($name){
    return '<h1>Hello </h1>'.$name;
})->name('hello.name');

Route::fallback(function(){
    return view('fallback');
});

Route::get('/add-users', function(){
    return view('users.add_users');
})->name('users.add');
