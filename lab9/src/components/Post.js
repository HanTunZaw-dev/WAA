import React, {useContext} from 'react'
import { Selected } from '../store/Selected'

export default function Post({ id, title, author, handleClick }) {
    console.log('RENDER POST')
    const setSelected = useContext(Selected)

    return (
        <div className="card post-box" onClick={() => setSelected(id)}>
            <div className="card-body">
                <h5 className="card-title">{title}</h5>
                <h6 className="card-subtitle mb-2 text-muted">Author: {author}</h6>
                <p className="card-text">Id: {id}</p>
            </div>
        </div>
    )
}
