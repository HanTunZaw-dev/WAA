import React,{useState} from 'react'
import PostDetail from '../components/PostDetail'
import Posts from '../components/Posts'
import AddPost from '../components/AddPost'
import { Selected } from '../store/Selected';

export default function Dashboard() {
    
    console.log('RENDER DASHBOARD')
    const [fetchFlag, setFetchflag] = useState(true);    
    const [clickedItemId, setClickedItemId] = useState(0)
 
    
    const handleClickedItem = (id) =>{
        setClickedItemId(id)        
    }

    const changeFetchFlag = () =>{
       setFetchflag(!fetchFlag)
    }

  return (
    <div>
      <Selected.Provider value={handleClickedItem}>        
        <Posts fetchFlag={fetchFlag}/>

        <AddPost changeFetchFlag={changeFetchFlag} />
        {
            clickedItemId !== 0  &&
            <PostDetail postId={clickedItemId}  changeFetchFlag={changeFetchFlag}  />
        }
        
        </Selected.Provider>
    </div>
  )
}
