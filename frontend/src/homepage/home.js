import React, {useEffect, useState} from 'react';

const Home = () => {
    const [keyword, setKeyword] = useState('');
    const [books, setBooks] = useState([]);

    const handleSearch = () => {
        fetch('/books/search', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ keyword })
        })
            .then(response => response.json())
            .then(data => setBooks(data))
            .catch(error => console.error(error));
    }

    return (
        <div>
            <div className="row">
            <div className="col-3"></div>
                <div className="col-6 mt-5">
            <input type="text" value={keyword} onChange={e => setKeyword(e.target.value)} />
            <button onClick={handleSearch} className="ms-4">Search</button>
            {books.map(book => (
                <div key={book.id}>
                    <h2>{book.title}</h2>
                    <p><b>Author name: </b>{book.author.name}</p>
                    <p><b>Author surname: </b>{book.author.surname}</p>
                    <p><b>Book year: </b>{book.year}</p>
                </div>
            ))}
        </div>
            </div>
            <div className="col-3"></div>
        </div>
    );
}

export default Home;