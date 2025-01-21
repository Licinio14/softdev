
@extends('layouts.fo_layout')

@section('content')
    <h1>Aqui vês todos os users</h1>

    <hr><hr>
    <p>Name: {{ $cesaeInfo['name']}}</p>
    <p>Address: {{ $cesaeInfo['address']}}</p>
    <p>Email: {{ $cesaeInfo['email']}}</p>
    <hr><hr><br><br>


    <hr>
    @foreach ($userInfo as $array)
        <ul>
            <li>ID: {{ $array['id']}}</li>
            <li>Name: {{ $array['name']}}</li>
            <li>Phone: {{ $array['phone']}}</li>
        </ul>
        <hr>
    @endforeach


@endsection
