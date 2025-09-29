import { useEffect, useState } from "react";

function AppCSR() {
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/posts")
      .then((res) => res.json())
      .then((data) => setPosts(data.slice(0, 20))); // 10개만 출력
  }, []);

  return (
    <div>
      <h1>게시글 목록 (CSR with Mock API)</h1>
      <ul>
        {posts.map((post) => (
          <li key={post.id}>
            <strong>{post.title}</strong>
            <br />
            {post.body}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default AppCSR;
