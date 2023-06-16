import axios from 'axios'
import React, { useState, useEffect } from 'react'

export default function Comments({ postId }) {
    console.log('RENDER COMMENTS')
    const [comments, setComments] = useState([])

    const fetchComments = () => {
        axios.get(`comments/post/${postId}`)
            .then(res => {
                setComments(res.data)
                console.log(res.data)
            }).catch(err => {
                console.log(err)
            })
    }
    useEffect(() => {
        fetchComments()
    }, [postId])

    return (
        
        <ul className="list-group list-group-flush">
            {
                comments.map(c =>
                    <li className="list-group-item" key={c.id}>
                        {c.name}
                    </li>
                )
            }
        </ul>

    )
}
