@extends('layouts.fo_layout')

@section('content')

    <h1>As prendas sao: </h1>
    <br>

    <table class="table table-dark table-striped table-hover text-center">

        <tr>
            <td>Nome</td>
            <td>Valor previsto</td>
            <td>Pessoa de Destino</td>
            <td>Apagar entrada</td>
        </tr>

        @foreach ($data as $newData)
                <tr>
                    <td onclick="window.location='{{ route('gifts.info', $newData->id) }}';" style="cursor: pointer;">{{ $newData->name }}</td>
                    <td onclick="window.location='{{ route('gifts.info', $newData->id) }}';" style="cursor: pointer;">{{ $newData->price }}</td>
                    <td onclick="window.location='{{ route('gifts.info', $newData->id) }}';" style="cursor: pointer;">{{ $newData->userName }}</td>
                    <td onclick="window.location='{{ route('gifts.delete', $newData->id) }}';" style="cursor: pointer;"><img src="{{asset('img/delete.png')}}" alt="imagem aleatoria" class="img-delete"></img></td>
                </tr>
        @endforeach

    </table>
@endsection
