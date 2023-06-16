import React, {useContext} from 'react'
import { Selected } from '../store/Selected'

export default function Post({ id, title, author, handleClick }) {
    console.log('RENDER POST')
    const postStyle = {
        width: '18rem'
    }

    const setSelected = useContext(Selected)

    /* for lab 8 - going back to Posts, pass via props. Post > Posts > Dashboard
    const ownClick = () => {
        handleClick(id)//this id is back to HOC handleClick prop, which is Posts
        //console.log(`Post : ${id}`)
    }
    */

    return (
        /* for lab 8
         <div className="card post-box" onClick={ownClick}>
        */
        // pass back to Context that store data, wrapp in Dashboard, no more passing via Posts
        <div className="card post-box" onClick={() => setSelected(id)}>
            <div className="card-body">
                <h5 className="card-title">{title}</h5>
                <h6 className="card-subtitle mb-2 text-muted">Author: {author}</h6>
                <p className="card-text">Id: {id}</p>
            </div>
        </div>
    )
}
