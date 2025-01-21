
@extends('layouts.fo_layout')

@section('content')
    <h1>Olá estou em casa.</h1>
    <img src="{{asset('img/photo.png')}}" alt="imagem aleatoria" class="img-home"></img>

    <p>{{ $contactInfo['name'] }}</p>
    <p>{{ $contactInfo['email'] }}</p>

@endsection

@section('batatas')
    <h1>{{ $myvar }}</h1>
@endsection


