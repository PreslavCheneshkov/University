import imgTodo from './assets/pendingTask.png'
import imgCompleted from './assets/completedTask.jpg'
import './Tasks.css'

function Tasks(props) {
    return <>
        <h3>{props.title}</h3>
        {props.tasks.map(task => {
            return <>
            <h4 key={task.id}>Описание на задачата: {task.description}</h4>
            <img src={task.isCompleted ? imgCompleted : imgTodo} />
            </>
        })}
    </>
}

export default Tasks;