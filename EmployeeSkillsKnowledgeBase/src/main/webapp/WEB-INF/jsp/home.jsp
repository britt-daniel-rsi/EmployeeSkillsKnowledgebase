<h2>Greeting</h2>
<h3>{{homeCtrl.greeting}}</h3>
<div ng-show="authenticated">
<table>
<tr>
    <td>Id</td>
    <td>Name</td>
    </tr>
    <tr ng-repeat="user in users">
     <td>{{user.id}}</td>
     <td>{{user.userName}}</td>
    
    </tr>
    </table>
</div>
<div  ng-show="!authenticated">
    <p>Login to see your greeting</p>
</div>