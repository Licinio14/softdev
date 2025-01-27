
@extends('layouts.fo_layout')

@section('content')

    <h1>As tarefas disponiveis sao: </h1>
    <br>

    <table class="table table-dark table-striped table-hover text-center">

        <tr>
            <td>ID</td>
            <td>Tarefa</td>
            <td>Estado</td>
            <td>Limite</td>
            <td>Pessoa Responsavel</td>
        </tr>

        @foreach ( $data as $newData )

                <tr>
                    <td>{{ $newData->id}}</td>
                    <td>{{ $newData->name}}</td>
                    <td>
                        @if ($newData->status == 0)
                            Por Fazer
                        @elseif ($newData->status == 1)
                            Concluido
                        @endif
                    </td>
                    <td>{{ $newData->due_at}}</td>
                    <td>{{ $newData->userName}}</td>
                </tr>

        @endforeach

    </table>

    <br>
    <hr>
    <br>
@endsection
