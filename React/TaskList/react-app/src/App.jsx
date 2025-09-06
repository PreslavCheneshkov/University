import { useState } from 'react'
import './App.css'
import Header from'./Header.jsx'
import Tasks from './Tasks.jsx'

function App() {
  const [count, setCount] = useState(0)

  const todoTasks = [ 
    { 
      id: 1,
      description:"Курсова работа СТ",
      isCompleted: false 
    }, 
    {
      id: 2,
      description: "Подготовка за изпит НП",
      isCompleted: false
    }];
  const completedTasks = [ 
    {
      id: 3,
      description: "Курсова работа ЕАИ",
      isCompleted: true
    },
    {
      id: 4,
      description: "Пазаруване от Лидл",
      isCompleted: true
    }
  ];

  console.log('in App.jsx');
  return  <div>
        <Header />
      < Tasks tasks={todoTasks} title="Задачи за изпълнение" />
      < Tasks tasks={completedTasks} title="Изпълнени задачи" />    
    </div>
}

export default App
