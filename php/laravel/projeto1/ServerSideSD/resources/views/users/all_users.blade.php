
@extends('layouts.fo_layout')

@section('content')

    <h1>Aqui vês todos os users</h1>

    <hr><hr>
    <p>Name: {{ $contactPerson->name}}</p>
    <p>Address: {{ $contactPerson->address}}</p>
    <p>Email: {{ $contactPerson->email}}</p>
    <hr><hr><br><br>


    <hr><hr>
    <table class="table table-dark table-striped table-hover text-center">

        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Email</td>
            <td>Password</td>
        </tr>

        @foreach ($userInfo as $array)

                <tr>
                    <td>ID: {{ $array->id}}</td>
                    <td>Name: {{ $array->name}}</td>
                    <td>Email: {{ $array->email}}</td>
                    <td>Password: {{ $array->password}}</td>
                </tr>

        @endforeach

    </table>
    <hr><hr>


@endsection
