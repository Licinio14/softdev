<?php


use Illuminate\Support\Facades\Route;
use App\Http\Controllers\HomeControler;
use App\Http\Controllers\UserControler;
use App\Http\Controllers\GiftsControler;
use App\Http\Controllers\TasksControler;
use App\Http\Controllers\FallBackControler;

// Route::get('/', function () {
//     return view('welcome');
// });

Route::get('/', [HomeControler::class, 'index']);

Route::get('/home', [HomeControler::class, 'index'])->name('home');

Route::get('/users', [UserControler::class, 'allUser'])->name('users.show');

Route::get('/hello/{name}', [UserControler::class, 'nameUser'] )->name('hello.name');

Route::fallback([FallBackControler::class, 'notFound']);

Route::get('/add-users', [UserControler::class, 'addUser'] )->name('users.add');

Route::get('/all-tasks', [TasksControler::class, 'allTasks'] )->name('tasks.all');

Route::get('/showall-tasks', [TasksControler::class, 'showAllTasks'] )->name('tasks.showAll');

Route::get('/showall-gifts', [GiftsControler::class, 'showAllGifts'] )->name('gifts.all');

Route::get('/showinfo-gifts/{id}', [GiftsControler::class, 'showInfoGifts'] )->name('gifts.info');

Route::get('/delete-gifts/{id}', [GiftsControler::class, 'deleteGifts'] )->name('gifts.delete');
